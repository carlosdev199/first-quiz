package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {
    private int quartersInserted;

    private static VendingMachineImpl instance;

    private VendingMachineImpl() {
        // Constructor para no hacer la creación directa de instancias
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachineImpl();
        }
        return instance;
    }

    @Override
    public void insertQuarter() {
        quartersInserted++;
    }

    @Override
    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
        if (name.equals("ScottCola")) {
            if (quartersInserted >= 3) {
                quartersInserted -= 3;
                return new Drink() {
                    @Override
                    public String getName() {
                        return "ScottCola";
                    }

                    @Override
                    public boolean isFizzy() {
                        return true;
                    }
                };
            } else {
                throw new NotEnoughMoneyException();
            }
        } else if (name.equals("KarenTea")) {
            if (quartersInserted >= 4) {
                quartersInserted -= 4;
                return new Drink() {
                    @Override
                    public String getName() {
                        return "KarenTea";
                    }

                    @Override
                    public boolean isFizzy() {
                        return false;
                    }
                };
            } else {
                throw new NotEnoughMoneyException();
            }
        } else {
            throw new UnknownDrinkException();
        }
    }
}
