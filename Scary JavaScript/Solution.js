import {RECIPE} from "./Recipe";

// Scenario 1
export function howLongDoesItTake(){
    var arrayOfTimers = RECIPE.times.cake.concat(RECIPE.times.buttercream);
    var totalTime = 0;
    for(var timer of arrayOfTimers){
        totalTime = totalTime + Number(timer);
    }
    return totalTime;
}

// Scenario 2
export function getQuantityOfIngredient(ingredient, numberOfCakes){
    var quantityOfIngredient = 0;
    var unit = "";
    for (var ingredientOfCake of RECIPE.ingredients.cake){
        if(ingredientOfCake.name === ingredient){
            quantityOfIngredient = ingredientOfCake.quantity * numberOfCakes;
            unit = " " + ingredientOfCake.unit;
            if(ingredient === "eggs"){
                quantityOfIngredient = (Number(ingredientOfCake.quantity) + 1) * numberOfCakes;
                break;
            }
        }
    }
    return quantityOfIngredient.toString() + unit;
}

// Scenario 3
export function getPurchaseList(){
    var calculator_funcs = [];
    var ingredients = RECIPE.ingredients.buttercream.concat(RECIPE.ingredients.cake);
    for(let ingredient of ingredients){
        calculator_funcs.push(function(result) {
            var quantityOfIngredient = result[ingredient.name] ? result[ingredient.name] : 0;
            result[ingredient.name] = quantityOfIngredient + Number(ingredient.quantity);
            return result;
        });

    }
    var result = {};
    for (var calculator_func of calculator_funcs) {
        result = calculator_func(result);
    }
    return result;
}

// Scenario 4
export function calculateDifficulty(){
    var arrayOfTimers = RECIPE.times.cake.concat(RECIPE.times.buttercream);
    var difficulties = [];
    for(var timer of arrayOfTimers){
        if(timer == 0){
            difficulties.push("super easy");
            continue;
        }
        if(timer <= 10){
            difficulties.push("easy");
            continue;
        }
        if(10 < timer && timer < 20){
            difficulties.push("medium");
            continue;
        }
        if(20 < timer && timer <= 30) {
            difficulties.push("difficult");
            continue;
        }
        difficulties.push("hard");
    }
    return difficulties;
}