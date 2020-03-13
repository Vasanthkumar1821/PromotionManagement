package com.avps.Promotion.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avps.Promotion.Entity.Promotion;
import com.avps.Promotion.Service.PromotionService;

@RestController
@RequestMapping("/api")
public class PromotionRestController {

	private PromotionService promotionService;

	@Autowired
	public PromotionRestController(PromotionService thePromotionService) {
		promotionService = thePromotionService;
	}

	// Finding all Promotions
	@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping("/promotions")
	public List<Promotion> findAll() {
		System.out.println("printing alllll");
		return promotionService.findAll();
	}

	// Promotion find by id
	@GetMapping("/promotions/{promotionId}")
	public Promotion getPromotion(@PathVariable int promotionId) {

		Promotion thePromotion = promotionService.findById(promotionId);

		if (thePromotion == null) {
			throw new RuntimeException("Promotion id not found - " + promotionId);
		}

		return thePromotion;
	}

	// Inserting Promotions
	@CrossOrigin(origins = "http://localhost:9090")
	@PostMapping(value = "/promotions", headers = "Accept=application/json")
	public Promotion addPromotion(@RequestBody Promotion thePromotion) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		System.out.println("inserting data...");

		thePromotion.setId(0);

		promotionService.save(thePromotion);

		return thePromotion;
	}

	// Updating the Promotion by id
	@CrossOrigin(origins = "http://localhost:9090")
	@PutMapping("/promotions")
	public Promotion updatePromotion(@RequestBody Promotion thePromotion) {

		/*
		 * , @PathVariable int promotionId thePromotion =
		 * promotionService.findById(promotionId); if (thePromotion == null) { throw new
		 * RuntimeException("Promotion id not found - " + promotionId); }
		 */
		promotionService.save(thePromotion);

		return thePromotion;
	}

	// Delete Promotions
	@CrossOrigin(origins = "http://localhost:9090")
	@DeleteMapping("/promotions/{promotionId}")
	public List<Promotion> deletePromotion(@PathVariable int promotionId) {

		Promotion thePromotion = promotionService.findById(promotionId);

		// throw exception if null

		if (thePromotion == null) {
			throw new RuntimeException("Promotion id not found - " + promotionId);
		}

		promotionService.deleteById(promotionId);

		return promotionService.findAll();
	}

}
