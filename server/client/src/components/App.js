import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';

import Header from "./Header";
import Landing from "./Landing";
import Contact from "./Contact";
import Categories from "./Categories";
import Products from "./Products"
import Cart from "./Cart";
import Checkout from "./Checkout";
import ProductDetailed from "./ProductDetailed";

import "./css/main_styles.css";
import "./css/product.css";
import "./css/product_responsive.css";
import "./css/cart.css";
import "./css/cart_responsive.css";
import "./css/categories_responsive.css";
import "./css/categories.css";
import "./css/checkout_responsive.css";
import "./css/checkout.css";
import "./css/contact_responsive.css";
import "./css/contact.css";
import "./css/main_styles.css";
import "./css/responsive.css";


class App extends React.Component {
    render() {
        return (
            <div>
                <BrowserRouter>
                <div>
                    <Header />
                    <Route exact path='/' component={Landing} />
                    <Route exact path="/contact" component={Contact} />
                    <Route exact path="/products" component={Products} />
                    <Route exact path="/categories" component={Categories} />
                    <Route exact path="/cart" component={Cart} />
                    <Route exact path="/product_detailed" component={ProductDetailed} />
                    <Route exact path="/checkout" component={Checkout} />
                </div>
                </BrowserRouter>
            </div>
        )
    }
};

export default App;