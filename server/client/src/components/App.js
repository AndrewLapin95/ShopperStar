import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';

import Header from "./Header";
import Landing from "./Landing";

import "./css/main_styles.css";
import "./css/product.css";
import "./css/product_responsive.css";
import "./css/cart_responsive.css";
import "./css/cart.css";
import "./css/categories_responsive.css";
import "./css/categories.css";
import "./css/checkout_responsive.css";
import "./css/checkout.css";
import "./css/contact_responsive.css";
import "./css/contact.css";
import "./css/main_styles.css";
import "./css/responsive.css";

const Dashboard = () => <h2>Dashboard</h2>
const SurveyNew = () => <h2>SurveyNew</h2>

class App extends React.Component {
    render() {
        return (
            <div>
                <BrowserRouter>
                <div>
                    <Header />
                    <Route exact path='/' component={Landing} />
                    <Route exact path="/surveys" component={Dashboard}/>
                    <Route path="/surveys/new" component={SurveyNew} />
                </div>
                </BrowserRouter>
            </div>
        )
    }
};

export default App;