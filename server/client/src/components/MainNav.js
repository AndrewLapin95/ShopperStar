import React from 'react';

class MainNav extends React.Component {
    render() {
        return (
            <nav className="main_nav">
                <ul>
                    <li className="hassubs active">
                        <a href="index.html">Home</a>
                            <ul>
                                <li><a href="categories.html">Categories</a></li>
                                <li><a href="product.html">Product</a></li>
                                <li><a href="cart.html">Cart</a></li>
                                <li><a href="checkout.html">Check out</a></li>
                                <li><a href="contact.html">Contact</a></li>
                            </ul>
                            </li>
                            <li className="hassubs">
                                <a href="categories.html">Categories</a>
                                <ul>
                                    <li><a href="categories.html">Category1</a></li>
                                    <li><a href="categories.html">Category2</a></li>
                                    <li><a href="categories.html">Category3</a></li>
                                    <li><a href="categories.html">Category4</a></li>
                                    <li><a href="categories.html">Category5</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Products</a></li>
                            <li><a href="#">Account</a></li>
                </ul>
            </nav>
        );
    }
}

export default MainNav;