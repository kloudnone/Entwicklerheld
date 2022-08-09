import React, { Component } from 'react';

const PizzaList = ({pizzaOffers, friends, onClickCallback}) => {
    return (
        <ul>
            {pizzaOffers.map(pizza => {
                return (
                    <li onClick={onClickCallback(pizza, friends)}>
                        {pizza.name}
                    </li>
                )
            })}
        </ul>
    )
}

function printPizzaFans(friends, pizzaOffers) {
    return friends.map(
        friend => {
            const favPizza = []
            let mostPrefs = 0;

            pizzaOffers.forEach(
                pizza => {
                    const hasNoGo = pizza.toppings.some(topping => friend.noGos.includes(topping))

                    if (hasNoGo == false) {
                        const prefCount = friend.preferences.filter(preference => pizza.toppings.includes(preference)).length

                        if (prefCount > mostPrefs) {
                            favPizza.length = 0;
                            mostPrefs = prefCount;
                        }

                        if (prefCount >= mostPrefs && !favPizza.includes((pizza.name))) {
                            favPizza.push((pizza.name));
                        }
                    }
                }
            );
        
            return {
                name: friend.name,
                favouritePizza: favPizza.sort().join(", ")
            };
        }
    );
}

function printFriendsForAPizza(pizza, friends) {
    const pizzaForFriends = [];
    let mostPrefs = 0;

    friends.forEach(
        friend => {
            const hasNoGo = pizza.toppings.some(topping => friend.noGos.includes(topping));

            if (hasNoGo == false) {
                const prefCount = friend.preferences.filter(preference => pizza.toppings.includes(preference)).length;

                if (prefCount > mostPrefs) {
                    pizzaForFriends.length = 0;
                    mostPrefs = prefCount;
                }

                if (prefCount >= mostPrefs && !pizzaForFriends.includes((friend.name))) {
                    pizzaForFriends.push(friend.name);
                }
            }
        }
    )

    return pizzaForFriends.sort().join(", ")
}

export { PizzaList, printPizzaFans, printFriendsForAPizza }