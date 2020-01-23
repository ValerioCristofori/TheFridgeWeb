package logic.implementation;

public class ListAllFood {
	private static String[] list = {"Aceto balsamico", "Aceto di mele","Aceto di vino    ","Aceto di vino rosso    ","Aglio     ","Albume d'uovo    ","Alcool alimentare    ",
			"Amido di mais    ","Arancia    ","Arancia  scorza     ","Avocado    ","Basilico     ","Bicarbonato    ","Brodo di carne    ","Brodo vegetale    ","Burro    ",
			"Burro  eventuale     ","Cacao in polvere    ","Candito d'arancia    ","Candito di cedro    ","Cannella    ","Cannella  eventuale     ","Capperi    ","Carciofo    ",
			"Carota    ","Cioccolato    ","Cipolla     ","Cipolla di Tropea    ","Cipolla di Tropea  eventuale     ","Cipolla fresca    ","Cipolla rossa    ",
			"Condimento sott'olio per insalate di pasta o di riso    ","Curcuma  eventuale     ","Erba cipollina  eventuale     ","Essenza di mandorle    ","Fagioli cannellini    ",
			"Fagioli cannellini secchi    ","Fagiolini    ","Farina    ","Farina di ceci    ","Finocchio    ","Galletti  funghi freschi     ","Grana grattugiato    ",
			"Grana grattugiato  eventuale     ","Latte    ","Lenticchie rosse decorticate    ","Lievito per dolci    ","Limone  scorza     ","Limone  succo     ",
			"Maiale  lonza o prosciutto     ","Maiale  Macinato di maiale     ","Mandarino    ","Mandorle    ","Mandorle  eventuali     ","Manzo  macinato di manzo     ",
			"Mela    ","Melanzana    ","Menta    ","Merluzzo    ","Nocciole  farina     ","Noce moscata    ","Noce moscata  eventuale     ","Olio di semi di arachide    ",
			"Olio extravergine d’oliva     ","Olio extravergine d’oliva  eventuale     ","Olive nere    ","Olive nere  eventuali     ","Origano    ","Palombo    ","Pane    ",
			"Pane raffermo o secco    ","Pangrattato    ","Parmigiano grattugiato    ","Parmigiano grattugiato  eventuale     ","Pasta    ","Pasta  tagliatelle   eventuale     ",
			"Patata    ","Pecorino romano  eventuale     ","Pepe    ","Pepe  eventuale     ","Peperoncino    ","Peperoncino  eventuale     ","Peperone    ","Pesce spada    ","Pinoli    ",
			"Pinoli  eventuali     ","Pollo  petto     ","Pomodori ciliegini    ","Pomodori secchi    ","Pomodoro     ","Porcini  funghi freschi     ","Porcini secchi    ","Porro    ",
			"Prezzemolo    ","Ricotta di mucca    ","Riso arborio    ","Riso carnaroli    ","Riso originario    ","Riso vialone nano    ","Rosmarino    ","Rosmarino  eventuale     ",
			"Rosolio di menta    ","Rum    ","Salmone    ","Salsa di soia    ","Salsiccia    ","Salvia    ","Scalogno    ","Sedano    ","Tahin    ","Tilsiter    ","Timo    ",
			"Timo  eventuale     ","Tofu    ","Uova    ","Uova  eventuali     ","Uvetta    ","Vanillina    ","Vino bianco    ","Yogurt    ","Zafferano    ","Zucca    ","Zucchero    ",
			"Zucchero a velo    ","Zucchero a velo vanigliato    ","Zucchero di canna    ","Zucchine    " };
	
	//non deve essere istanziata
	private ListAllFood() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * @return the listAllFood
	 */
	public static String[] getListAllFood() {
		return list;
	}

	
	
	
}
