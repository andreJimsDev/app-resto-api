package com.opendevup.shop.application.usecases;

public interface UseCase<T> {
    void execute(T request);
}
