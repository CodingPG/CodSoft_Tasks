package com.api.Ministers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
public class MinistersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinistersApplication.class, args);
	}

	// Example data structure to store representatives by locality
	private static final Map<String, List<Map<String, String>>> REPRESENTATIVES_DATA = new HashMap<>() {{
		put("Andhra Pradesh", Arrays.asList(
				Map.of("name", "N. Chandrababu Naidu", "designation", "Chief Minister", "phone", "+91-40-23476603", "email", "arvind@delhi.gov.in"),
				Map.of("name", "Konidala Pawan Kalyan", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Arunachal Pradesh", Arrays.asList(
				Map.of("name", "Pema Khandu", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Chowna Mein", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Assam", Arrays.asList(
				Map.of("name", "Himanta Biswa Sharma", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Bihar", Arrays.asList(
				Map.of("name", "Nitish Kumar", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Samrat Choudhary and Vijay Kumar Sinha", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Chhattisgarh", Arrays.asList(
				Map.of("name", "Vishnu Deo Sai", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Arun Sao and Vijay Sharma", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Goa", Arrays.asList(
				Map.of("name", "Pramod Sawant", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Gujarat", Arrays.asList(
				Map.of("name", "Bhupendrabhai Patel", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Haryana", Arrays.asList(
				Map.of("name", "Nayab Singh Saini", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Himachal Pradesh", Arrays.asList(
				Map.of("name", "Sukhvinder Singh Sukhu", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Mukesh Agnihotri", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Jharkhand", Arrays.asList(
				Map.of("name", "Hemant Soren", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Karnataka", Arrays.asList(
				Map.of("name", "Siddaramaiah", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "D. K. Shivakumar", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Kerala", Arrays.asList(
				Map.of("name", "Pinarayi Vijayan", "designation", "Chief Minister", "phone", "Not publicly available", "email", " chiefminister@kerala.gov.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Madhya Pradesh", Arrays.asList(
				Map.of("name", "Mohan Yadav", "designation", "Chief Minister", "phone", "+91-755-2441581", "email", "cm@mp.nic.in"),
				Map.of("name", "Rajendra Shukla and Jagdish Devda", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Maharashtra", Arrays.asList(
				Map.of("name", "Devendra Fadnavis", "designation", "Chief Minister", "phone", "+91-22-22025222", "email", "cm@maharashtra.gov.in"),
				Map.of("name", "Eknath Shinde and Ajit Pawar", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Manipur", Arrays.asList(
				Map.of("name", "N. Biren Singh", "designation", "Chief Minister", "phone", "+91-385-2450137", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Meghalaya", Arrays.asList(
				Map.of("name", "Conrad Sangma", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Prestone Tynsong and Sniawbhalang Dhar", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Mizoram", Arrays.asList(
				Map.of("name", "Lalduhoma", "designation", "Chief Minister", "phone", "Not publicly available", "email", "Not publicly available"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Nagaland", Arrays.asList(
				Map.of("name", "Neiphiu Rio", "designation", "Chief Minister", "phone", "+91-370-2270076", "email", "Not publicly available"),
				Map.of("name", "Yanthungo Patton and T. R. Zeliang", "designation", "Deputy Chief Minister", "phone", "Not publicly available", "email", "Not publicly available")
		));
		put("Odisha", Arrays.asList(
				Map.of("name", "Mohan Charan Majhi ", "designation", "Chief Minister", "phone", "+91-674-2531100", "email", "cmo@nic.in"),
				Map.of("name", "Kanak Vardhan Singh Deo and Pravati", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Punjab", Arrays.asList(
				Map.of("name", "Bhagwant Mann", "designation", "Chief Minister", "phone", "+91-172-2740325", "email", "cm@punjab.gov.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Rajasthan", Arrays.asList(
				Map.of("name", " Ashok Gehlot", "designation", "Chief Minister", "phone", "+91-141-2227656", "email", "stalin@chennai.gov.in"),
				Map.of("name", "Diya Kumari and Prem Chand Bairwa", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Sikkim", Arrays.asList(
				Map.of("name", "Prem Singh Tamang ", "designation", "Chief Minister", "phone", "+91-3592-202659", "email", "cm-skm@nic.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Tamil Nadu", Arrays.asList(
				Map.of("name", "M. K. Stalin", "designation", "Chief Minister", "phone", "+91-44-25672345", "email", "cmcell@tn.gov.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Telangana", Arrays.asList(
				Map.of("name", "K. Chandrashekar Rao", "designation", "Chief Minister", "phone", "+91-40-23455205", "email", "cm@telangana.gov.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("Tripura", Arrays.asList(
				Map.of("name", "Manik Saha", "designation", "Chief Minister", "phone", "Not Publicly available", "email", "Not Publicly available"),
				Map.of("name", "Jishnu Dev Varma", "designation", "Deputy Chief Minister", "phone", "Not Publicly available", "email", "Not Publicly available")
		));
		put("Uttar Pradesh", Arrays.asList(
				Map.of("name", "Yogi Adityanath", "designation", "Chief Minister", "phone", "+91-522-2239296", "email", "cmup@nic.in"),
				Map.of("name", "Keshav Prasad Maurya and Brajesh Pathak", "designation", "Deputy Chief Minister", "phone", "Not Publicly available", "email", "Not Publicly available")
		));
		put("Uttarakhand", Arrays.asList(
				Map.of("name", "Pushkar Singh Dhami", "designation", "Chief Minister", "phone", " +91-135-2711101", "email", "cm-uk@nic.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
		put("West Bengal", Arrays.asList(
				Map.of("name", "Mamta Banerjee", "designation", "Chief Minister", "phone", "+91-33-22145555", "email", "cm-wb@nic.in"),
				Map.of("name", "Position not currently appointed", "designation", "Deputy Chief Minister", "phone", "", "email", "")
		));
	}};

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/representatives")
	public Map<String, Object> getRepresentatives(@RequestParam(required = false, defaultValue = "default") String locality) {
/**
 * Get the list of public representatives for a specified locality.
 *
 * @param locality The name of the locality to fetch representatives for.
 * @return Map<String, Object> Nested list of representatives with their name, designation, phone, and email.
 * @throws RuntimeException If the locality is not found in the data.
 */
		List<Map<String, String>> localityData = REPRESENTATIVES_DATA.get(locality);
		if (!REPRESENTATIVES_DATA.containsKey(locality)) {
			return Map.of("error", "Locality not found. Please provide a valid locality.");
		}
		return Collections.singletonMap("locality", REPRESENTATIVES_DATA.get(locality));
	}
}

