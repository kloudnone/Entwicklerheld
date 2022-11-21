package de.entwicklerheld.flightsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FlightService implements IFlightService {
    private Collection<Flight> availableFlights;

    public static FlightService of(Collection<Flight> availableFlights) {
        return new FlightService(availableFlights);
    }

    private FlightService(Collection<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public Stream<Flight> getFullFlights() {
        return availableFlights
            .stream()
            .filter(flight -> flight.getAvailableSeats() == 0);
    }

    public Stream<Flight> getFlightsForDestination(Airport destination) {
        return availableFlights
            .stream()
            .filter(flight -> flight.getDestination() == destination);
    }

    public Stream<Flight> getFlightsForOrigin(Airport origin) {
        return availableFlights
            .stream()
            .filter(flight -> flight.getOrigin() == origin);
    }

    public List<Flight> getShortestFlightByRoute(Airport origin, Airport destination) {
        List<Flight> shortestRoute = new ArrayList<>();
        List<Flight> possibleFlights = availableFlights
                                                    .stream()
                                                    .filter(flight -> flight.getAvailableSeats() != 0)
                                                    .collect(Collectors.toList());
        
        List<Airport> airports = new ArrayList<>();
        airports.add(origin);
        
        for(Flight flight : possibleFlights) {
            
            if(!airports.contains(flight.getOrigin())) {
                airports.add(flight.getOrigin());
            }
            
            if(!airports.contains(flight.getDestination())) {
                airports.add(flight.getDestination());
            }
        }

        int[][] airportDistance = new int[airports.size()][airports.size()];
        for(Airport firstAirport : airports) {
            for(Airport secondAirport : airports) {
                
                Flight currentFlight = null;
                
                for(Flight flight : possibleFlights) {
                    if(flight.getOrigin().equals(firstAirport) && flight.getDestination().equals(secondAirport)) {
                        currentFlight = flight;
                        break;
                    }    
                }

                if(currentFlight != null) {
                    airportDistance[airports.indexOf(firstAirport)][airports.indexOf(secondAirport)]
                        = Integer.parseInt(Long.toString(currentFlight.getDuration().getSeconds()));
                }
            }
        }

        Integer [][] backtrackingResults = backtrackingAlgorithm(airportDistance);
        int destinationIndex = 0;

        for(Airport currentAirport : airports) {
            if(currentAirport.equals(destination)) {
                destinationIndex = airports.indexOf(currentAirport);
            }
        }

        List<Integer> flights = new ArrayList<>();
        flights.add(0, destinationIndex);
        int previous = destinationIndex;
        boolean finished = false;

        while(!finished) {
            int smallestValue = Integer.MAX_VALUE;
            int smallestIndex = 0;

            for(int i = 0; i < backtrackingResults.length; i++) {
                if(backtrackingResults[i][0] == backtrackingResults[previous][2] 
                    && backtrackingResults[i][1] < smallestValue) {
                        smallestIndex = i;
                        smallestValue = backtrackingResults[i][1];
                }
            }

            flights.add(0, smallestIndex);
            previous = smallestIndex;

            if(previous == 0) {
                finished = true;
            }
        }

        List<Airport> airportList = new ArrayList<>();

        for(Integer i : flights) {
            airportList.add(airports.get(i));
        }

        for(int i = 0; i < airportList.size() - 1; i++) {
            for(Flight flight : possibleFlights) {
                if(flight.getOrigin().equals(airportList.get(i)) 
                    && flight.getDestination().equals(airportList.get(i + 1))) {
                        shortestRoute.add(flight);
                    }
            }
            
            if(shortestRoute.size() == airportList.size()) {
                break;
            }
        }
        
        return shortestRoute;
    }

    public Integer[][] backtrackingAlgorithm(int[][] graph) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        Integer[][] results = new Integer[graph.length][3];

        for(int i = 0; i < graph.length; i++) {
            results[i][0] = i;

            if(i == 0) {
                results[i][1] = 0;
            } else {
                results[i][1] = Integer.MAX_VALUE;
            }

            results [i][2] = null;
            queue.add(i);
        }

        while(visited.size() < queue.size()) {
            int smallestValue = Integer.MAX_VALUE;
            int smallestIndex = -1;

            for(int i = 0; i < results.length; i++) {
                if(results[i][1] < smallestValue && !visited.contains(i)) {
                    smallestValue = results[i][1];
                    smallestIndex = i;
                } else if(queue.size() - 1 == visited.size() && !visited.contains(i)) {
                    smallestValue = results[i][1];
                    smallestIndex = i;
                }
            }

            for(int i = 0; i < graph.length; i++) {
                if(!visited.contains(i) && graph[smallestIndex][i] != 0) {
                    int distance = smallestValue + graph[smallestIndex][i];
                    if(distance < results[i][1]) {
                        results[i][1] = distance;
                        results[i][2] = smallestIndex;
                    }
                }
            }

            visited.add(smallestIndex);
        }
        return results;
    }
}