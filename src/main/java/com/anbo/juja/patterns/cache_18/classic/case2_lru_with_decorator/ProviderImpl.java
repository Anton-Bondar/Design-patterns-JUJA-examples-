package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// а это наш сервис на Марсе, он очень тугой
// ресурсы через него получать очень долго
public class ProviderImpl implements Provider {

    @Override
    public Resource get(int id) {
        sleep(1000);
        Resource resource = new Resource(id);
        System.out.println("Created " + resource);
        return resource;
    }

    // метод для задержки в миллисекундах
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
