package service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MonederoService implements InitializingBean {

    private List<Monedero> repository;

    private Logger logger = LoggerFactory.getLogger(Monedero.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        this.repository = new ArrayList<>();
    }

    public void save(Monedero monedero) {
        this.repository.add(monedero);
    }

    @Cacheable(cacheNames = "moenederos")
    public Monedero findById(String phonenumber) {
        Monedero p = this.repository
                .stream()
                .filter(it -> it.getId()== phonenumber)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        logger.info("Item {} retrieved from list (not cached)", p.toString());
        return p;
    }
}
