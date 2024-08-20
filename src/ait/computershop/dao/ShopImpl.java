package ait.computershop.dao;

import ait.computershop.model.Computer;

public class ShopImpl implements Shop {
    private Computer[] computers;
    private int count;

    // Constructor
    public ShopImpl(int capacity) {
        this.computers = new Computer[capacity];
        this.count = 0;

    }

    @Override
    public boolean addComputer(Computer computer) {
        //The computer is null is full or the book already exists
        if (computer == null || count == computers.length || findComputer(computer.getBarcode()) != null) {
            return false;
        }
        // в конец массива добавить новый элемент
        computers[count] = computer;// size - это индекс первого свободного места в массиве
        count++;
        return true;
    }

        @Override
        public Computer findComputer ( long barcode){
            for (int i = 0; i < count; i++) {
                if (computers[i].getBarcode() == barcode) {
                    return computers[i];
                }
            }
            return null;
        }

        @Override
        public Computer updateComputer (Computer computer){
            for (int i = 0; i < count; i++) {
                if(computers[i].getBarcode() == computer.getBarcode()){
                    computers[i] = computer;
                    return computer;
                }
            }
            return null;
        }

        @Override
        public Computer removeComputer ( long barcode){
            for (int i = 0; i < count; i++) {
                if(computers[i].getBarcode() == barcode){
                    Computer victim = computers[i];
                    computers[i] = computers[count - 1];
                    computers[count -1] = null;
                    count--;
                    return victim;
                }

            }

            return null;
        }

        @Override
        public void printComputer () {
            for (int i = 0; i < count; i++) {
                System.out.println(computers[i]);
            }

        }

        @Override
        public int quantity () {
            return count;
        }

    }





