package _01Logger.models.interfaces;

import java.math.BigInteger;

public interface File {

    BigInteger getSize();

    void write(String log);
}
