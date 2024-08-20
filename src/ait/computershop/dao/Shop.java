package ait.computershop.dao;
//Computer (Laptop, SmartPhone) - Shop, найти компьютеры со скидкой на BlackFriday

import ait.computershop.model.Computer;

public interface Shop {

    boolean addComputer (Computer computer);
    Computer findComputer (long barcode);
    Computer updateComputer(Computer computer);
    Computer removeComputer(long barcode);
    void printComputer();
    int quantity();


}
