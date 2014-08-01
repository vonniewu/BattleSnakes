package com.hakrx.battlesnakes;

import java.util.HashMap;

public class ServiceManager {

    private static HashMap<Class, Object> services;

    static {
        ServiceManager.services = new HashMap<Class, Object>();
    }

    public static <T> T getService(Class serviceType) {
        return (T) ServiceManager.services.get(serviceType);
    }

    public static void registerService(Class serviceType, Object service) {
        if (!serviceType.isInterface()) {
            String message = "Cannot register service of type %s. Service type must be an interface.";
            throw new IllegalArgumentException(String.format(String.format(message, serviceType)));
        }

        if (!serviceType.isAssignableFrom(service.getClass())) {
            String message = "Cannot register service. Service of type: %s does not implement interface: %s";
            throw new IllegalArgumentException(String.format(message, service.getClass(), serviceType));
        }

        ServiceManager.services.put(serviceType, service);
    }

}
