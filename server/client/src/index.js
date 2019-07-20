import 'jquery';
import reduxThunk from 'redux-thunk';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import "./components/css/cart.css";
import "./components/css/font-awesome.min.css";
import "./components/css/categories.css";
import "./components/css/checkout.css";
import "./components/css/product.css";
import "./components/css/product_responsive.css";
import "./components/css/contact.css";
import "./components/css/cart_responsive.css";
import "./components/css/categories_responsive.css";
import "./components/css/checkout_responsive.css";
import "./components/css/contact_responsive.css";
import "./components/css/main_styles.css";
import "./components/css/responsive.css";


import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';

import App from './components/App';
import reducers from './reducers';


const store = createStore(reducers, {}, applyMiddleware(reduxThunk));

ReactDOM.render( <Provider store = { store } > < App /> </Provider>, 
    document.querySelector('#root')
);