# game-of-life
Implementation of Conway's "Game of Life" written in Java

This repo contains the code for an implementation of Conway's "Game of Life," a simple game in which users create structures of cells that interact according to pre-determined rules.

# Overview

In this game, cells (represented by squares) are displayed as hollow or filled, as an "on/off" or "alive/dead" state. Every time the "update" button is clicked, the cells toggle their states according to the following rules:

* If an "alive" cell is surrounded by less than 2 "alive" cells, it dies.

* If an "alive" cell is surrounded by exactly 2 or 3 "alive" cells, it does not change state.

* If an "alive" cell is surrounded by more than 3 "alive" cells, it dies.

* If a "dead" cell is surrounded by exactly 3 "alive" cells, it becomes an "alive" cell.

These simple rules can create patterns in the motions of cell structures when generated with the correct starting positions.

# Implementation

The implementation of this game is rather simple, containing a JComponent subclass named GameOfLife, an instance of which is created by the main method. On every click of a square or the update button, the JComponent class updates (changing all cells' states according to the rules) and redraws itself. The GameOfLife object contains a two-dimensional array of "Coordinates" objects, each of which is a simple object that contains a cell's column, row, and state. On an update, the GameOfLife object creates a new array of Coordinates and replaces it with the original array.

# Demonstration

The current state of the program contains a timer that continuously clicks the update button, causing a pre-loaded "glider" structure to move throughout the field. In the normal use of this game, the timer would not be present, allowing a player to click on squares to toggle their states manually to create patterns.

This project was completed in a team in CSSE220 - Object-Oriented Software Development at Rose-Hulman Institute of Technology.