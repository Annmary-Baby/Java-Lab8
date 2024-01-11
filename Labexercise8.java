import java.util.*;


class Appliance {
    private String name;

    public Appliance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Appliance: " + name;
    }
}


class AppliancesService {
    private List<Appliance> applianceList;
    private Set<String> serviceAreas;
    private Map<Appliance, Integer> applianceRepairCosts;
    private Queue<Appliance> repairQueue;

    public AppliancesService() {
        this.applianceList = new ArrayList<>();
        this.serviceAreas = new HashSet<>();
        this.applianceRepairCosts = new HashMap<>();
        this.repairQueue = new LinkedList<>();
    }

  
    public void addAppliance(Appliance appliance) {
        applianceList.add(appliance);
    }

    
    public void addServiceArea(String area) {
        serviceAreas.add(area);
    }

 
    public void assignRepairCost(Appliance appliance, int cost) {
        applianceRepairCosts.put(appliance, cost);
    }


    public void enqueueForRepair(Appliance appliance) {
        repairQueue.offer(appliance);
    }


    public Appliance dequeueForRepair() {
        return repairQueue.poll();
    }


    public void displayAppliances() {
        System.out.println("Appliances:");
        for (Appliance appliance : applianceList) {
            System.out.println(appliance);
        }
    }


    public void displayServiceAreas() {
        System.out.println("Service Areas: " + serviceAreas);
    }


    public void displayRepairCosts() {
        System.out.println("Appliance Repair Costs:");
        for (Map.Entry<Appliance, Integer> entry : applianceRepairCosts.entrySet()) {
            System.out.println(entry.getKey().getName() + ": $" + entry.getValue());
        }
    }


    public void displayRepairQueue() {
        System.out.println("Repair Queue:");
        for (Appliance appliance : repairQueue) {
            System.out.println(appliance);
        }
    }
}


public class Labexercise8 {
    public static void main(String[] args) {
        
        AppliancesService appliancesService = new AppliancesService();

       
        appliancesService.addAppliance(new Appliance("Refrigerator"));
        appliancesService.addAppliance(new Appliance("Washing Machine"));
        appliancesService.addAppliance(new Appliance("Oven"));

       
        appliancesService.addServiceArea("North Area");
        appliancesService.addServiceArea("South Area");

     
        appliancesService.assignRepairCost(new Appliance("Refrigerator"), 100);
        appliancesService.assignRepairCost(new Appliance("Washing Machine"), 80);
        appliancesService.assignRepairCost(new Appliance("Oven"), 120);

     
        appliancesService.enqueueForRepair(new Appliance("Refrigerator"));
        appliancesService.enqueueForRepair(new Appliance("Washing Machine"));
        appliancesService.enqueueForRepair(new Appliance("Oven"));


        appliancesService.displayAppliances();
        appliancesService.displayServiceAreas();
        appliancesService.displayRepairCosts();
        appliancesService.displayRepairQueue();

        
        Appliance repairedAppliance = appliancesService.dequeueForRepair();
        System.out.println("Appliance Repaired: " + repairedAppliance);
    }
}
