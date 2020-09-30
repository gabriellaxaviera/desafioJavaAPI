package com.gabriellaxavier.desafioconcrete.error;

public class ExceptionDetails {
    private String message;

    public ExceptionDetails() {
    }

    public String getMessage() {
        return message;
    }

    public static final class ResourceNotFoundBuilder {
        private String message;

        private ResourceNotFoundBuilder() {
        }

        public static ResourceNotFoundBuilder newBuilder() {
            return new ResourceNotFoundBuilder();
        }

        public ResourceNotFoundBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionDetails build() {
            ExceptionDetails resourceNotFound = new ExceptionDetails();
            resourceNotFound.message = this.message;
            return resourceNotFound;
        }
    }
}
