package t02;

import java.io.IOException;

class WrongPropertyFormatException extends IOException {
    WrongPropertyFormatException() {
    }

    WrongPropertyFormatException(String message) {
        super(message);
    }
}
