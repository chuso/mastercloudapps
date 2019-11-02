package es.urjccode.mastercloudapps.adcs.draughts.models;

public enum Error {
    INVALID_INPUT,
    OUT_COORDINATE, 
    EMPTY_ORIGIN, 
    OPPOSITE_PIECE, 
    NOT_DIAGONAL, 
    BAD_DISTANCE,
    NOT_EMPTY_TARGET, 
    NOT_ADVANCED, 
    BAD_EATING;
}