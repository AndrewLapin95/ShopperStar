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
import ReturnPage from "./ReturnPage";


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
                    <Route exact path="/return" component={ReturnPage} />
                </div>
                </BrowserRouter>
            </div>
        )
    }
};

export default App;