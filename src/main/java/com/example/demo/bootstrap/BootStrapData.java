package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    if (productRepository.count() == 0) {
        Product mountainBike = new Product("Mountain Bicycle", 109.99, 19);
        Product toddlerBike = new Product("Toddler Bicycle", 59.99, 9);
        Product sportsBike = new Product("BMX Bicycle", 129.99, 15);
        Product eBike = new Product("Electric Bicycle", 899.99, 6);
        Product foldBike = new Product("Folding Bicycle", 659.99, 5);
        productRepository.save(mountainBike);
        productRepository.save(toddlerBike);
        productRepository.save(sportsBike);
        productRepository.save(eBike);
        productRepository.save(foldBike);
    }
    if (partRepository.count() == 0){
        Part bikeChain = new InhousePart();
        bikeChain.setId(2);
        bikeChain.setName("Bicycle Chain");
        bikeChain.setPrice(13.99);
        bikeChain.setInv(10);
        bikeChain.setMinInv(2);
        bikeChain.setMaxInv(40);

        Part dropBar = new InhousePart();
        dropBar.setId(3);
        dropBar.setName("Drop Handle Bar");
        dropBar.setPrice(29.99);
        dropBar.setInv(8);
        dropBar.setMinInv(4);
        dropBar.setMaxInv(30);

        Part phoneMount = new InhousePart();
        phoneMount.setId(4);
        phoneMount.setName("Cellphone Mount");
        phoneMount.setPrice(9.99);
        phoneMount.setInv(9);
        phoneMount.setMaxInv(10);
        phoneMount.setMinInv(1);

        Part handleBar = new InhousePart();
        handleBar.setId(5);
        handleBar.setName("Flat Handle Bar");
        handleBar.setPrice(19.99);
        handleBar.setInv(8);
        handleBar.setMinInv(2);
        handleBar.setMaxInv(40);

        partRepository.save(bikeChain);
        partRepository.save(dropBar);
        partRepository.save(phoneMount);
        partRepository.save(handleBar);
    }
    if (outsourcedPartRepository.count()==0){
        OutsourcedPart leatherSeat = new OutsourcedPart();
        leatherSeat.setId(6);
        leatherSeat.setCompanyName("Gusti Leather US");
        leatherSeat.setName("Full Grain Leather Bicycle Seat");
        leatherSeat.setPrice(89.99);
        leatherSeat.setInv(4);
        leatherSeat.setMinInv(2);
        leatherSeat.setMaxInv(9);
        outsourcedPartRepository.save(leatherSeat);
    }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
