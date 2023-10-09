package com.example.thesis.service.model;

public class InstructionFiles {

    private String fileDestination;
    private int instructionFileId;
    private int productId;


    public InstructionFiles() {
    }


    public InstructionFiles(String fileDestination, int instructionFileId, int productId) {
        this.fileDestination = fileDestination;
        this.productId = productId;
        this.instructionFileId = instructionFileId;
    }


    public String getFileDestination() {
        return fileDestination;
    }

    public void setFileDestination(String fileDestination) {
        this.fileDestination = fileDestination;
    }

    public int getInstructionFileId() {
        return instructionFileId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setInstructionFileId(int instructionFileId) {
        this.instructionFileId = instructionFileId;
    }
}
