package myudfs;
import java.io.IOException;
import java.util.List;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.*;

public class companies extends EvalFunc<Tuple> {
	public Tuple exec(Tuple input) throws IOException {
		String[] listCompanies={"Exxon Mobil", "JPMorgan Chase", "General Electric", "Royal Dutch Shell", "ICBC", "HSBC Holdings", "PetroChin", "Berkshire Hathaway", "Wells Fargo", "Petrobras-Petróleo Brasil", "BP", "Chevron", "China Construction Bank", "Citigroup", "Gazprom", "Wal-Mart Stores", "Volkswagen Group", "Total", "Agricultural Bank of China", "BNP Paribas", "Bank of China", "Apple", "Banco Santander", "Sinopec-China Petroleum", "Toyota Motor", "Samsung Electronics", "ConocoPhillips", "Vodafone", "ENI", "Itaú Unibanco Holding", "China Mobile", "IBM", "AT&T", "Pfizer", "Procter & Gamble", "Mitsubishi UFJ Financial", "Daimler", "American Intl Group", "ING Group", "Nestlé", "Statoil", "Microsoft", "Banco Bradesco", "Ford Motor", "Nippon Telegraph & Tel", "AXA Group", "Commonwealth Bank", "GDF Suez", "BHP Billiton", "Allianz", "Siemens", "Deutsche Bank", "Barclays", "Banco do Brasil", "MetLife", "Vale", "Telefónica", "Johnson & Johnson", "Westpac Banking Group", "Honda Motor", "BMW Group", "Novartis", "General Motors", "Sumitomo Mitsui Financial", "China Life Insurance", "Verizon Communications", "Hewlett-Packard", "Lukoil", "Rio Tinto", "Royal Bank of Canada", "Rosneft", "UBS", "EDF", "BASF", "ENEL", "National Australia Bank", "Goldman Sachs Group", "Sanofi ", "ANZ", "Merck & Co", "Comcast", "TD Bank", "Bank of America", "BBVA-Banco Bilbao Vizcaya", "Nissan Motor", "Intel", "Coca-Cola", "PepsiCo", "Saudi Basic Industries", "Sberbank", "Cisco Systems", "Bank of Nova Scotia", "Anheuser-Busch InBev", "Société Générale", "Mitsubishi Corp", "Hyundai Motor", "Zurich Financial Services", "Mizuho Financial", "Glencore International", "Ping An Insurance Group", "Ping An Insurance Group", "Intesa Sanpaolo", "Google", "Roche Holding", "UnitedHealth Group", "Caterpillar", "Unilever", "Bank of Communications", "Oracle", "France Telecom", "Standard Chartered", "América Móvil", "Prudential Financial", "Boeing", "American Express", "Kraft Foods", "CVS Caremark", "Tesco", "GlaxoSmithKline", "United Technologies", "Walt Disney", "US Bancorp", "Prudential", "Reliance Industries", "Credit Suisse Group", "China Shenhua Energy", "Abbott Laboratories", "Schlumberger", "Hitachi", "ArcelorMittal", "Iberdrola", "Xstrata", "Mitsui & Co", "Suncor Energy", "Nordea Bank", "Bayer Group", "Ecopetrol", "UniCredit Group", "Anglo American", "Repsol YPF", "Dow Chemical", "AstraZeneca", "RWE Group", "Home Depot", "Occidental Petroleum", "Cnooc", "Bank of Montreal", "State Bank of India", "Canon", "TNK-BP Holding", "Posco", "M?ller-Maersk", "Shanghai Pudong Dev Bk", "Itaúsa", "China Telecom", "Hon Hai Precision", "Generali Group", "News Corp", "Target", "China Merchants Bank", "Vinci", "EI du Pont de Nemours", "Philip Morris International", "Hutchison Whampoa", "Telecom Italia", "BG Group", "PTT PCL", "United Parcel Service", "Swiss Re ", "Jardine Matheson", "Oil & Natural Gas", "Canadian Imperial Bank", "Dell", "EADS", "British American Tobacco", "JX Holdings", "Time Warner", "National Grid", "PNC Financial Services", "Munich Re", "Vivendi", "Capital One Financial", "McDonald's", "Volvo Group", "WellPoint", "ABB", "Renault", "Wesfarmers", "Softbank", "Deere & Co", "KDDI", "Bank of New York Mellon", "Deutsche Telekom", "M", "Schneider Electric", "Telstra", "Saint-Gobain", "Apache", "Sumitomo Corp", "Surgutneftegas", "Imperial Tobacco Group", "Honeywell International", "Union Pacific", "China Citic Bank", "Toshiba", "Lockheed Martin", "Qualcomm", "Eli Lilly & Co", "L'Oréal Group", "Deutsche Post", "Christian Dior", "Amgen", "Shinhan Financial", "Aflac", "Japan Tobacco", "Itochu", "Bristol-Myers Squibb", "Southern Co", "Lowe's Cos", "Walgreen", "Exelon", "Danone", "Teva Pharmaceutical Inds", "Panasonic", "Barrick Gold", "Hyundai Heavy Industries", "China Minsheng Banking", "SAP", "Travelers Cos", "Altria Group", "Seven & I Holdings", "SAIC Motor", "Denso", "EMC", "Freeport-McMoRan Copper", "Samsung Life Insurance", "Valero Energy", "Costco Wholesale", "Archer Daniels Midland", "Ericsson", "BT Group", "Tokio Marine Holdings", "Industrial Bank ", "General Dynamics", "CCCC-China Communications Construction", "Wilmar International", "SABMiller", "AIA Group", "SSE", "China Pacific Insurance", "Natixis", "ACE", "Kia Motors", "Diageo", "VTB Bank", "KB Financial Group", "Standard Bank Group", "Woolworths", "Medtronic", "DNB", "Kansai Electric Power", "Brookfield Asset Mgmt", "BCE", "Nippon Steel", "China State Construction", "East Japan Railway", "McKesson", "Hess", "Takeda Pharmaceutical", "FedEx", "Canadian Natural Resources", "BlackRock", "Gas Natural Group", "Time Warner Cable", "NextEra Energy", "Duke Energy", "Legal & General Group", "Mitsubishi Electric", "Husky Energy", "Johnson Controls", "SEB", "Svenska Handelsbanken", "Sasol", "Taiwan Semiconductor", "Indian Oil", "Halliburton", "Marubeni", "Aetna", "SK Innovation ", "Air Liquide", "Linde", "Power Corp of Canada", "Emerson Electric", "TeliaSonera", "SingTel", "LyondellBasell Industries", "Continental", "Commerzbank", "State Street", "CaixaBank", "Icici Bank", "Central Japan Railway", "Danaher", "Devon Energy", "Marathon Petroleum ", "CNP Assurances", "Visa", "Bridgestone", "Sun Hung Kai Properties", "Allstate", "Swedbank", "BAE Systems", "Carnival", "Fiat Group", "Dominion Resources", "DBS Group", "Komatsu", "Marathon Oil", "Directv", "Eletrobrás", "China Everbright Bank", "Ebay", "American Electric", "Woori Finance Holdings", "FirstRand", "China Unicom", "Henkel", "Old Mutual", "Baoshan Iron & Steel", "Chubu Electric Power", "Reckitt Benckiser Group", "Hyundai Mobis", "BB&T", "Accenture", "Chubb", "National Oilwell Varco", "NTPC", "MTN Group", "Norilsk Nickel", "Amazon.com", "Enbridge", "Raytheon", "Metro AG", "Cigna", "OMV Group", "Saudi Telecom", "Carrefour", "Tata Motors", "Northrop Grumman", "Resona Holdings", "Baker Hughes", "NIKE", "Telenor", "Bouygues", "Teck Resources", "China Railway Group", "Mapfre", "Tyco International", "Garanti Bank", "Texas Instruments", "Inditex", "PPR", "Kimberly-Clark", "Loews", "TransCanada", "Maybank", "Grupo  ACS", "SK Holdings ", "WPP", "Koç Holding", "HCA Holdings", "Discover Financial Services", "Illinois Tool Works", "Rolls-Royce", "Michelin Group", "Viacom", "Bharti Airtel", "Pernod Ricard", "FirstEnergy", "Cardinal Health", "Express Scripts", "Baxter International", "Shenzhen Development  Bank", "Centrica", "EDP-Energias de Portugal", "International Paper", "CSX", "Fiat Industrial", "Chesapeake Energy", "Fresenius", "KPN", "Aviva", "Inpex", "PPL", "CEZ Group", "Monsanto", "Cenovus Energy", "General Mills", "Oversea-Chinese Banking", "PG&E", "JFE Holdings", "Coal India", "United Overseas Bank", "Norfolk Southern", "Macy's", "Canadian National Railway", "Mitsubishi Estate", "Royal Bank of Scotland", "E.ON", "Colgate-Palmolive", "Automatic Data", "Lafarge", "Ahold", "Lloyds Banking Group", "CBS", "Aeon", "CenturyLink", "Hartford Financial Services", "Covidien", "Consolidated Edison", "Heineken Holding", "Ameriprise Financial", "Tata Steel", "Humana", "Isbank", "Kyocera", "Las Vegas Sands", "Xerox", "Sistema JSFC", "Thermo Fisher Scientific", "China Vanke", "Fortum", "Corning", "PICC Property & Casualty", "CLP Holdings", "Mitsui Fudosan", "QBE Insurance Group", "VimpelCom", "Fujitsu", "Femsa", "LG Chem", "Macquarie Group", "China Railway Construction", "Alstom", "Shin-Etsu Chemical", "Sabanci Holding", "Fujifilm Holdings", "Potash of Saskatchewan", "Mitsubishi Chemical", "Dongfeng Motor Group", "CRH", "Public Service Enterprise", "Merck", "Praxair", "Syngenta", "Gilead Sciences", "Raiffeisen Bank International", "Peugeot", "Bunge", "Manulife Financial", "Nomura Holdings", "Eaton", "Kroger", "Entergy", "Mosaic", "Novo Nordisk", "Compass Group", "Best Buy", "Orix", "Akbank", "CIC Group", "EOG Resources", "Delta Air Lines", "Rogers Communications", "Cummins", "Formosa Petrochemical", "Sempra Energy", "Sony", "Bank Rakyat Indonesia", "Crédit Agricole", "National Bank of Canada", "Fifth Third Bancorp", "UC Rusal", "SunTrust Banks", "HeidelbergCement", "Tokyo Gas", "Hana Financial Group", "Bank Mandiri", "H&M", "Alcoa", "Aon", "Suncorp-Metway", "CIMB Group Holdings", "MCC", "Paccar", "Sysco", "Mitsubishi Heavy Industries", "Danske Bank", "Progressive", "Waste Management", "Grupo Mexico", "TE Connectivity", "Sampo", "Norsk Hydro", "Sumitomo Electric", "Aisin Seiki", "Goldcorp", "Nintendo", "Etisalat", "Richemont", "Hua Xia Bank", "Banca MPS", "Wm Morrison Supermarkets", "Suzuki Motor", "Telus", "Fubon Financial", "Nan Ya Plastic", "Lotte Shopping", "Akzo Nobel", "Dai-ichi Life Insurance", "HDFC Bank", "Hannover Re", "Formosa Chemicals", "United Continental Holdings", "China Steel", "China Coal Energy", "Larsen & Toubro", "Atlas Copco", "Tatneft", "Sime Darby", "Qatar National Bank", "Otsuka Holding", "Asahi Glass", "J Sainsbury", "Swire Pacific", "Companhia Siderurgica", "Omnicom Group", "SK Telecom", "AMP", "Swisscom", "Cheung Kong Holdings", "Standard Life", "Saudi Electricity", "Safran", "Al Rajhi Bank", "TJX Cos", "Magna International", "Reynolds American", "Reed Elsevier", "Industrial Bank of Korea", "KT", "AmerisourceBergen", "Associated British Foods", "Holcim", "Xcel Energy", "Kohl's", "Kinder Morgan", "Adidas", "Charles Schwab", "HDFC", "Agrium", "Tenaris", "Carlsberg", "Principal Financial Group", "PPG Industries", "Marsh & McLennan", "Kellogg", "Aegon", "Ferrovial", "Nucor", "Staples", "Murphy Oil", "Nokia", "Air Products & Chemicals", "Yara International", "MS&AD Insurance", "Toyota Tsusho", "Sandvik", "Toray Industries", "Korea Electric Power", "Chunghwa Telecom", "Franklin Resources", "Applied Materials", "Toyota Industries", "Keppel", "Huaneng Power Intl", "Transneft", "Astellas Pharma", "Alcatel-Lucent", "PGE Polska Grupa", "Sodexo", "S-Oil", "Cemig", "Sun Life Financial", "DISH Network", "ThyssenKrupp Group", "Research In Motion", "Progress Energy", "Spectra Energy", "New China Life Insurance", "Tele Norte Leste", "China Cosco Holdings", "Quanta Computer", "Novatek", "Yum Brands", "HTC", "MasterCard", "Anadarko Petroleum", "Westfield Group", "PKO Bank Polski", "Woodside Petroleum", "Li & Fung", "Falabella", "MOL Hungarian Oil", "Kingfisher", "Wharf (Holdings)", "MGM Mirage", "Bankia", "Daiichi Sankyo", "George Weston", "Stryker", "Eurasian Natural Resources", "Sumitomo Realty & Dev", "Talisman Energy", "Citic Pacific", "Bharat Heavy Electricals", "Philips", "CME Group", "Yanzhou Coal Mining", "HJ Heinz", "Starbucks", "Singapore Airlines", "GFNorte", "Deutsche Boerse", "Simon Property Group", "MTR", "Formosa Plastics", "Thales", "Newmont Mining", "Daqin Railway", "Samsung Fire & Marine", "Asahi Group Holdings", "Nippon Yusen", "T&D Holdings", "Galp Energia", "KBC Group", "Motorola Solutions", "Onex", "Rostelecom", "Grupo P?o de Açúcar", "Public Bank", "Unibail-Rodamco", "NKSJ Holdings", "Allied Irish Banks", "Sanlam", "Asahi Kasei", "Halkbank", "Swiss Life Holding", "Cencosud", "Antarchile", "Novolipetsk Steel", "Siam Commercial Bank", "Citic Securities", "Liberty Interactive", "PTT Global Chemical", "Royal DSM", "Tata Consultancy Services", "BRF-Brasil Foods", "Punjab National Bank", "Parker-Hannifin", "Adecco", "Fanuc", "Air France-KLM", "Banco Popular Espa?ol", "National Bank of Kuwait ", "Henderson Land", "Swatch Group", "Noble Group", "Kasikornbank", "Vedanta Resources", "Stanley Black & Decker", "SLM", "Siam Cement", "BanColombia", "Marks & Spencer", "Kubota", "RSA Insurance Group", "DTE Energy", "CPFL Energia", "ASML Holding", "Veolia Environnement", "Becton, Dickinson", "M&T Bank", "Erste Group Bank", "British Sky Broadcasting", "Idemitsu Kosan", "LG Electronics", "Precision Castparts", "L- Communications", "Bank Central Asia", "Steel Authority of India", "Thomson Reuters", "Kyushu Electric Power", "PKN Orlen", "Sumitomo Mitsui Trust ", "Gree Electric Appliances", "Skanska", "Cathay Financial", "International Airlines", "Delphi Automotive ", "Bombardier", "IDGC Holding", "Abertis", "EnBW-Energie Baden", "Bank of Baroda", "Qatar Telecom", "KeyCorp", "Samba Financial Group", "Publicis Groupe", "Bank of Beijing", "Dollar General", "Isuzu Motors", "Kobe Steel", "West Japan Railway", "JBS", "Cliffs Natural Resources", "Telekom Indonesia", "Mitsui OSK Lines", "Cathay Pacific Airways", "Sprint Nextel", "Finmeccanica", "Hyundai Steel", "Kirin Holdings", "Vienna Insurance Group", "Newcrest Mining", "Atlantia", "Kao", "Korea Life Insurance", "Genting", "Peabody Energy", "Antofagasta", "CenterPoint Energy", "Wolseley", "Edison International", "Bangkok Bank", "Lincoln National", "LG Corp", "Seadrill", "China Yangtze Power", "ConAgra Foods", "Evraz Group", "Republic Services", "VF", "Technip", "Osaka Gas", "Yahoo", "Eisai", "Samsung C&T", "Voestalpine", "Northern Trust", "China Southern Airlines", "Ingersoll-Rand", "AES", "Axis Bank", "UPM-Kymmene", "RTL Group", "RusHydro", "Goodrich", "Evergrande Real Estate", "Sumitomo Metal Mining", "Seagate Technology", "National Bank of Abu Dhabi", "Holly", "China Eastern Airlines", "Samsung Heavy Industries", "Zoomlion Heavy Industry", "Aluminum Corp of China", "Datang International Power", "Korea Exchange Bank", "Tyson Foods", "Luxottica Group", "Celgene", "Broadcom", "Infosys Technologies", "Ecolab", "Kuehne + Nagel", "Safeway", "Estée Lauder Cos", "National Bank of Greece", "Wipro", "Tencent Holdings", "Transocean", "Industries Qatar", "AngloGold Ashanti", "Delhaize Group", "Fannie Mae", "Honam Petrochemical", "Grupo Aval", "Nexen", "Riyad Bank", "Yamada Denki", "Grupo Elektra", "Secom", "Poly Real Estate Group", "Fuji Heavy Industries", "Daiwa House Industry", "Sumitomo Chemical", "Fast Retailing", "China Resources Land", "Freddie Mac", "Gap", "Grupo Modelo", "Belgacom", "Williams Cos", "Symantec", "Fluor", "Investec", "Agilent Technologies", "Biogen Idec", "TRW Automotive Holdings", "Tokyu", "Tokyo Electric Power", "Bed Bath & Beyond", "Compal Electronics", "Sears Holdings", "Origin Energy", "Hindalco Industries", "Murata Manufacturing", "Sumitomo Metal Industries", "Wheelock & Co", "Federal Grid", "KGHM Polska Miedz", "Metalurgica Gerdau", "American Capital Agency Corp.", "Sharp", "Sekisui House", "Sinohydro Group ", "Weatherford International", "Deutsche Lufthansa", "Liberty Global", "Jiangxi Copper", "Solvay", "Ageas", "Dover", "SKF Group", "Fortescue Metals Group", "Limited Brands", "EnCana", "Areva", "China Resources Power Holdings", "Allergan", "First Gulf Bank", "New World Development", "CF Industries Holdings", "Canara Bank", "Equity Residential", "Credicorp", "ZTE", "Ameren", "Severstal", "China Resources Enterprise", "Shanghai Electric Group", "SCOR", "Turk Telekom", "Annaly Capital Management", "Nordstrom", "Industrias Pe?oles", "Tokyo Electron", "AutoZone", "Boston Scientific", "Grupa PZU", "Tohoku Electric Power", "Naspers", "LG Display", "Saudi British Bank", "Bâloise Group", "Mobily", "All Nippon Airways", "Dai Nippon Printing", "ITC", "Banque Saudi Fransi", "Ricoh", "Cognizant Technology", "Mediobanca", "CapitaLand", "Cemex", "Land Securities Group", "SanDisk", "Dexia", "Oneok", "Royal Caribbean Cruises", "Zain", "Avnet", "Vornado Realty", "Sabesp", "Axiata Group", "DSME", "Bank of East Asia", "Landesbank Berlin", "GD Midea Holding", "CA", "Stora Enso", "Capgemini", "SCA", "Tenaga Nasional", "Portugal Telecom", "Nidec", "Country Garden Holdings", "Mega Financial Holding", "Schindler Holding", "Power Assets Holdings", "Regions Financial", "Invesco", "Unum Group", "Navistar Intl", "Petronas Chemicals", "Weichai Power", "Mahindra & Mahindra", "GAIL", "Suning Appliance", "Whirlpool", "Bank of Ireland", "NEC", "Hyundai Engineering", "Ajinomoto", "Amcor", "Reinsurance Group of America", "Discovery Communications", "Banco de Sabadell", "Bank of Yokohama", "Flextronics International ", "Impala Platinum Holdings", "Santos", "TDK", "WW Grainger", "Anhui Conch Cement", "Kone", "Western Union", "Pgnig Group", "Golden Agri-Resources", "St Jude Medical", "Canadian Pacific Railway", "Priceline.com", "Chugoku Electric Power", "China National Building", "Pearson", "IntercontinentalExchange", "Hynix Semiconductor", "Ross Stores", "Coca-Cola Enterprises", "Mediolanum", "Bharat Petroleum", "VakifBank", "STMicroelectronics", "HCP", "Redecard", "Ralph Lauren", "McGraw-Hill Cos", "Finatis", "Delek Group", "Genuine Parts", "Sara Lee", "Steinhoff International", "Yamato Holdings", "Cameron International", "Rexel", "TD Ameritrade Holding", "Gold Fields", "Bank Negara Indonesia", "NetApp", "Chinatrust Financial", "Wendel", "Ensco", "Baidu", "Krung Thai Bank", "Western Digital", "Attijariwafa Bank", "Dentsu", "Bank Hapoalim", "Jeronimo Martins", "Infineon Technologies", "Shizuoka Bank", "Bidvest Group", "VMware", "Coach", "KazMunaiGas Exploration", "Cosmo Oil", "Mechel", "Bank of India", "Lenovo Group", "K+S", "Bank Leumi", "Grupo Inbursa", "Banque Nationale  Belgique", "Campbell Soup", "Essilor International", "Sany Heavy Industry", "Braskem", "Mylan", "Public Power"};
		Tuple result = TupleFactory.getInstance().newTuple();
		for(int i=0; i<1000; i++){
			Boolean present = ((String)input.get(0)).contains(listCompanies[i]);
			if(present) result.append(listCompanies[i]);
		}
		if(result.size()==0) return null;
		return result;
	}
}
