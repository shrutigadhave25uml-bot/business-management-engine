package com.business.model;

public class Manager extends Employee {
    private final int teamSize;

    public Manager(int id, String name, String department, double salary, int teamSize) {
        super(id, name, department, salary);
        if (teamSize < 0) throw new IllegalArgumentException("Team size cannot be negative");
        this.teamSize = teamSize;
    }

    public int getTeamSize() { return teamSize; }

    @Override
    public String getRole() { return "Manager"; }
}
