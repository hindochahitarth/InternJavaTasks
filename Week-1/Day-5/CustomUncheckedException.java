class CustomUncheckedException extends RuntimeException {

    public CustomUncheckedException() {
        super();
    }

    public CustomUncheckedException(String mssg) {
        super(mssg);
    }
}
