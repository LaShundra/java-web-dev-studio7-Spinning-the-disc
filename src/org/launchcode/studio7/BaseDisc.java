package org.launchcode.studio7;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class BaseDisc {
    private String name;
    private int storageCapacity;
    private int remainingStorageCapacity;
    private int capacityUsed;
    private String discType;
    private ArrayList<String> contents;


    public BaseDisc(String aName, int maxCapacity, String aType,
                    int someUsedCapacity){
        name = aName;
        storageCapacity = maxCapacity;
        discType = aType;
        capacityUsed = checkCapacity(someUsedCapacity);
        remainingStorageCapacity = spaceLeft();
    }
    private int checkCapacity(int dataWritten){
        if (storageCapacity < dataWritten){
            return storageCapacity;
        }
        return dataWritten;
    }

    private int spaceLeft(){
        return storageCapacity - capacityUsed;
    }

    public String discInfo(){
        return String.format("\nDisk name: %s\nMax capacity: %d" +
                "\nSpace used: %d\n", name, storageCapacity,
                capacityUsed, remainingStorageCapacity);
    }

    public String writeData(int dataSize){
        if (dataSize > remainingStorageCapacity){
            return "Not enough disc space!";
        }
        capacityUsed += dataSize;
        remainingStorageCapacity -= dataSize;

        return "Data written to disc. Remaining space = " + remainingStorageCapacity;

    }
}
