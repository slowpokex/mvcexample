package by.mine.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by harle on 02.03.2017.
 */

@WebFilter(filterName = "StatsFilter", urlPatterns = {"/**"})
public class StatsFilter implements Filter {

    private class TimeStatisticsMap extends LinkedHashMap<Integer, Integer> {

        private static final int MAP_SIZE = 24;
        private static final float LOAD_FACTOR = 1f;
        private Lock statLock = new ReentrantLock(true);

        public TimeStatisticsMap() {
            super(MAP_SIZE, LOAD_FACTOR, true);
            for (int i = 0; i < MAP_SIZE; i++) {
                this.put(i,0);
            }
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > MAP_SIZE;
        }

        @Override
        public Integer put(Integer key, Integer value) {
            return null;
        }

        @Override
        public boolean remove(Object key, Object value) {
            return false;
        }

        @Override
        public Integer remove(Object key) {
            return null;
        }

        public void registerInvoke() {
            statLock.lock();
            try {
                LocalTime time = LocalTime.now();
                int numberOfInvoke = super.get(time.getHour());
                super.put(time.getHour(), numberOfInvoke++);
            } finally {
                statLock.unlock();
            }
        }
    }


    private TimeStatisticsMap statisticMap = new TimeStatisticsMap();



    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        statisticMap.registerInvoke();
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
