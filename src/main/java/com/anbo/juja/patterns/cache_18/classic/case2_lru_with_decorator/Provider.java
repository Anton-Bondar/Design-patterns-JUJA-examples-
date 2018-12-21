package com.anbo.juja.patterns.cache_18.classic.case2_lru_with_decorator;

/**
 * Created by oleksandr.baglai on 11.01.2016.
 */
// даватор ресурсов по айдишечке
public interface Provider {
    Resource get(int key);
}
