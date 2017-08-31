package gotmap.data;

import gotmap.objects.Castle;
import gotmap.objects.CastleDisplayInfo;
import gotmap.objects.House;

import java.util.ArrayList;

public class HouseProvider {
    private ArrayList<House> houses;

    public ArrayList<House> GetAll() {
        return houses;
    }

    public void loadData() {
        houses = new ArrayList<>();

        House stark = new House("House Stark", "Winter is coming", "The North", "Winterfel", "487, 248", "stark.png");
        stark.members = new String[] {"Eddard Stark", "Catelyn Stark", "Robb Stark", "Sansa Stark", "Arya Stark", "Bran Stark", "Rickon Stark", "Jon Snow"};
        stark.castles = new Castle[] { new Castle("Winterfel", new CastleDisplayInfo(2, 1, 220, 20, 0, 0))};
        houses.add(stark);

        House lannister = new House("House Lannister", "Hear Me Roar", "The Westerlands", "Casterly Rock", "123, 456", "lannister.png");
        lannister.members = new String[] { "Tywin Lannister", "Joanna Lannister", "Jamie Lannister", "Cersei Lannister", "Tyrion Lannister" };
        lannister.castles = new Castle[] { new Castle("Casterly Rock", new CastleDisplayInfo(1, 3, 50, 0, 0, 0))};
        houses.add(lannister);

        House frey = new House("House Frey", "We Stand Together", "The North", "The Twins", "987, 478", "frey.png");
        frey.members = new String[] {"Walder Frey", "Stevron Frey", "Lothar Frey", "Roslin Frey", "Walda Frey", "Olyvar Frey", "Waldron Frey", "Derwa Frey", "Shirei Frey", "Serra Frey", "Neyela Frey"};
        frey.castles = new Castle[] { new Castle("The Twins", new CastleDisplayInfo(2, 2, 155, 5, 0, 0))};
        houses.add(frey);

        House baratheon = new House("House Baratheon", "Ours Is The Fury", "The Stormlands", "Storms End", "753, 159", "baratheon.png");
        baratheon.members = new String[] {"Sceffon Baratheon", "Cassana Baratheon", "Robert Baratheon", "Stannis Baratheon", "Renly Baratheon"};
        baratheon.castles = new Castle[] { new Castle("Storms End", new CastleDisplayInfo(3, 4, 0, 40, 0, 20))};
        houses.add(baratheon);

        House arryn = new House("House Arryn", "As High As Honor", "The Vale", "The Eyrie", "258, 852", "arryn.jpg");
        arryn.members = new String[] {"Jasper Arryn", "Lady Arryn", "Jon Arryn", "Lysa Arryn", "Alys Arryn", "Ronnel Arryn", "Robin Arryn"};
        arryn.castles = new Castle[] { new Castle("The Eyrie", new CastleDisplayInfo(3, 3, 0, 30, 0, 160))};
        houses.add(arryn);

        House martell = new House("House Martell", "Unbowed, Unbent, Unbroken", "Dorne", "Sunspear", "147, 741", "martell.png");
        martell.members = new String[] {"Elia Martell", "Oberyn Martell", "Trystane Martell", "Lewyn Martell", "Doran Martell"};
        martell.castles = new Castle[] { new Castle("Sunspear", new CastleDisplayInfo(3, 5, 10, 80, 0, 0))};
        houses.add(martell);

        House tully = new House("House Tully", "Family, Duty, Honor", "The Riverlands", "Riverrun", "321, 987", "tully.png");
        tully.members = new String[] {"Hoster Tully", "Minisa Tully", "Catelyn Tully", "Lysa Tully", "Edmure Tully"};
        tully.castles = new Castle[] { new Castle("Riverrun", new CastleDisplayInfo(2, 3, 0, 0, 0, 50))};
        houses.add(tully);

        House greyjoy = new House("House Greyjoy", "We Do Not Sow", "The Iron Islands", "The Pyke", "045, 745", "greyjoy.png");
        greyjoy.members = new String[] {"Euron Greyjoy II", "Alannys Greyjoy II", "Robin Geyjoy II", "Asha Greyjoy", "Theon Greyjoy II", "Euron Greyjoy III", "Harren Greyjoy", "Alyx Greyjoy"};
        greyjoy.castles = new Castle[] { new Castle("The Pyke", new CastleDisplayInfo(1, 3, 0, 0, 0, 130))};
        houses.add(greyjoy);

        House targaryan = new House("House Targaryen", "Fire & Blood", "Blackwater Bay", "Dragonstone", "021, 124", "targaryen.png");
        targaryan.members = new String[] {"Aerys Targaryen II", "Rhaella Targaryen", "Rhaegar Targaryen", "Viserys Targaryen III", "Daenerys Targaryen"};
        targaryan.castles = new Castle[] { new Castle("Dragonstone", new CastleDisplayInfo(3, 3, 70, 70, 0, 0))};
        houses.add(targaryan);

        House bolton = new House("House Bolton", "Our Blades Are Sharpe", "The North", "The Dreadfort", "985, 748", "bolton.png");
        bolton.members = new String[] {"Roose Bolton", "Walda Bolton", "Ramsay Bolton", "Domeric Bolton"};
        bolton.castles = new Castle[] { new Castle("The Dreadfort", new CastleDisplayInfo(3, 1, 160, 20, 0, 0))};
        houses.add(bolton);

        House mormont = new House("House Mormont", "Here We Stand", "The North", "Bear Island", "452, 236", "mormont.png");
        mormont.members = new String[] {"Joer Mormont", "Maege Mormont", "Lynesse Mormont", "Jorah Mormont"};
        mormont.castles = new Castle[] { new Castle("The Dreadfort", new CastleDisplayInfo(1, 1, 0, 57, 0, 0))};
        houses.add(mormont);

        House tyrell = new House("House Tyrell", "Growing Strong", "The Reach", "Highgarden", "124, 478", "tyrell.png");
        tyrell.members = new String[] {"Luthor Tyrell", "Olenna Tyrell", "Mace Tyrell", "Margaery Tyrell", "Loras Tyrell"};
        tyrell.castles = new Castle[] { new Castle("Highgarden", new CastleDisplayInfo(1, 4, 25, 57, 0, 0))};
        houses.add(tyrell);

    }
}
