package exec.dice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.dice.DiceData;
import logic.dice.DiceLogic;

public class DiceExec {

	public static void main(String[] args) {
		DiceData dd = null;
		DiceLogic dl = null;
		
		try {
			dd = new DiceData();
			dl = new DiceLogic(dd);
			dd.setDiceList(dl.diceAccum());
			dd.setDiceProb(dl.diceProb(dd.getDiceList()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//dl.printDiceList(dd.getDiceList());
			//dl.printDiceProb(dd.getDiceProb());
		}

	}// main

}// class
