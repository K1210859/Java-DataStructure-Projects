public class Counts {
    private int my4s, my3s, my2s, my1s, opp4s, opp3s, opp2s, opp1s;
    private Board board;
    private Location l;
    private char me, opp;

    public Counts(Board board, Location l, char me) {
        my1s = 0;
        my2s = 0;
        my3s = 0;
        my4s = 0;
        opp1s = 0;
        opp2s = 0;
        opp3s = 0;
        opp4s = 0;
        this.board = board;
        this.l = l;
        this.me = me;
        opp = (me =='X')?'O':'X';
        calculate();
    }

    public void calculate() {
        int c = l.getCol();
        int r = l.getRow();
        int s = l.getSheet();
        char[][][] b = board.getData();
        //horizontal
        int count = 1;
        for (int x = 0; x < board.numCols(); x++) {
            if (b[s][r][x] == me) {
                count++;
            } else if (b[s][r][x] == opp) {
                count = 0;
                break;
            }
        }
        addMe(count);
        //opponent horizontal
        count = 1;
        for (int x = 0; x < board.numCols(); x++) {
            if (b[s][r][x] == opp) {
                count++;
            } else if (b[s][r][x] == me) {
                count = 0;
                break;
            }
        }
        addOpponent(count);
        //vertical
        count = 1;
        for (int rr = 0; rr < board.numCols(); rr++) {
            if (b[s][rr][c] == me) {
                count++;
            } else if (b[s][rr][c] == opp) {
                count = 0;
                break;
            }
        }
        addMe(count);
        //opponent vertical
        count = 1;
        for (int rr = 0; rr < board.numCols(); rr++) {
            if (b[s][rr][c] == opp) {
                count++;
            } else if (b[s][rr][c] == me) {
                count = 0;
                break;
            }
        }
        addOpponent(count);
        //backwards
        count = 1;
        for (int ss = 0; ss < board.numCols(); ss++) {
            if (b[ss][r][c] == me) {
                count++;
            } else if (b[ss][r][c] == opp) {
                count = 0;
                break;
            }
        }
        addMe(count);
        //opponent backwards
        count = 1;
        for (int ss = 0; ss < board.numCols(); ss++) {
            if (b[ss][r][c] == opp) {
                count++;
            } else if (b[ss][r][c] == me) {
                count = 0;
                break;
            }
        }
        addOpponent(count);
        //z sheet diagonal
        if (c == r) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                if (b[s][aa][aa] == me) {
                    count++;
                } else if (b[s][aa][aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        //opponent z diagonal sheet
        if (c == r) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                if (b[s][aa][aa] == opp) {
                    count++;
                } else if (b[s][aa][aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //z diagonal 2
        if (c + r == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[s][aa][3 - aa] == me) {
                    count++;
                } else if (b[s][aa][3 - aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        // opp z diag 2
        if (c + r == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[s][aa][3 - aa] == opp) {
                    count++;
                } else if (b[s][aa][3 - aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //y plane d1
        if (c == s) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][r][aa] == me) {
                    count++;
                } else if (b[aa][r][aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        //opp y plane d1
        if (c == s) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][r][aa] == opp) {
                    count++;
                } else if (b[aa][r][aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //y plane d2
        if (c + s == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][r][3 - aa] == me) {
                    count++;
                } else if (b[aa][r][3 - aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        //opp y plane d2
        if (c + s == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][r][3 - aa] == opp) {
                    count++;
                } else if (b[aa][r][3 - aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //x plane d1
        if (r == s) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][c] == me) {
                    count++;
                } else if (b[aa][aa][c] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        //opp x plane d1
        if (r == s) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][c] == opp) {
                    count++;
                } else if (b[aa][aa][c] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //x plane d2
        if (r + s == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][3 - aa][c] == me) {
                    count++;
                } else if (b[aa][3 - aa][c] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
        }
        // opp x plane d2
        if (r + s == 3) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][3 - aa][c] == opp) {
                    count++;
                } else if (b[aa][3 - aa][c] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
        //special 1
        if ((c == 0 && r == 0 && s == 0) || (c == 1 && r == 1 && s == 1) || (c == 2 && r == 2 && s == 2) || (c == 3 && r == 3 && s == 3)) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][aa] == me) {
                    count++;
                } else if (b[aa][aa][aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][aa] == opp) {
                    count++;
                } else if (b[aa][aa][aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }

        //special 2
        if ((c == 3 && r == 0 && s == 0) || (c == 2 && r == 1 && s == 1) || (c == 1 && r == 2 && s == 2) || (c == 0 && r == 3 && s == 3)) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][3-aa] == me) {
                    count++;
                } else if (b[aa][aa][3-aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[aa][aa][3-aa] == opp) {
                    count++;
                } else if (b[aa][aa][3-aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }

        //special 3
        if ((c == 0 && r == 0 && s == 3) || (c == 1 && r == 1 && s == 2) || (c == 2 && r == 2 && s == 1) || (c == 3 && r == 3 && s == 0)) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[3-aa][aa][aa] == me) {
                    count++;
                } else if (b[3-aa][aa][aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[3-aa][aa][aa] == opp) {
                    count++;
                } else if (b[3-aa][aa][aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }

        //special 4
        if ((c == 3 && r == 0 && s == 3) || (c == 2 && r == 1 && s == 2) || (c == 1 && r == 2 && s == 1) || (c == 0 && r == 3 && s == 0)) {
            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[3-aa][aa][3-aa] == me) {
                    count++;
                } else if (b[3-aa][aa][3-aa] == opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for (int aa = 0; aa < 4; aa++) {
                //if (b[z][aa][3-aa])
                if (b[3-aa][aa][3-aa] == opp) {
                    count++;
                } else if (b[3-aa][aa][3-aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpponent(count);
        }
    }

    public void addMe(int c) {
        if (c == 1) {
            my1s++;
        } else if (c == 2) {
            my2s++;
        } else if (c == 3) {
            my3s++;
        } else if (c == 4) {
            my4s++;
        }
    }

    public void addOpponent(int c) {
        if (c == 1) {
            opp1s++;
        } else if (c == 2) {
            opp2s++;
        } else if (c == 3) {
            opp3s++;
        } else if (c == 4) {
            opp4s++;
        }
    }

    public int getMy4s() {
        return my4s;
    }

    public void setMy4s(int my4s) {
        this.my4s = my4s;
    }

    public int getMy3s() {
        return my3s;
    }

    public void setMy3s(int my3s) {
        this.my3s = my3s;
    }

    public int getMy2s() {
        return my2s;
    }

    public void setMy2s(int my2s) {
        this.my2s = my2s;
    }

    public int getMy1s() {
        return my1s;
    }

    public void setMy1s(int my1s) {
        this.my1s = my1s;
    }

    public int getOpp4s() {
        return opp4s;
    }

    public void setOpp4s(int opp4s) {
        this.opp4s = opp4s;
    }

    public int getOpp3s() {
        return opp3s;
    }

    public void setOpp3s(int opp3s) {
        this.opp3s = opp3s;
    }

    public int getOpp2s() {
        return opp2s;
    }

    public void setOpp2s(int opp2s) {
        this.opp2s = opp2s;
    }

    public int getOpp1s() {
        return opp1s;
    }

    public void setOpp1s(int opp1s) {
        this.opp1s = opp1s;
    }
}







