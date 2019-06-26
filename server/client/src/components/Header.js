import React, { Component } from 'react';

class Header extends Component { render() { return (
<header class="header">
    <div class="header_container">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="header_content d-flex flex-row align-items-center justify-content-start">
                        <div class="logo"><a href="#">ShopperStar</a></div>
                        <nav class="main_nav">
                            <ul>
                                <li class="hassubs active">
                                    <a href="index.html">Home</a>
                                    <ul>
                                        <li><a href="categories.html">Categories</a></li>
                                        <li><a href="product.html">Product</a></li>
                                        <li><a href="cart.html">Cart</a></li>
                                        <li><a href="checkout.html">Check out</a></li>
                                        <li><a href="contact.html">Contact</a></li>
                                    </ul>
                                </li>
                                <li class="hassubs">
                                    <a href="categories.html">Categories</a>
                                    <ul>
                                        <li><a href="categories.html">Category</a></li>
                                        <li><a href="categories.html">Category</a></li>
                                        <li><a href="categories.html">Category</a></li>
                                        <li><a href="categories.html">Category</a></li>
                                        <li><a href="categories.html">Category</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Accessories</a></li>
                                <li><a href="#">Account</a></li>
                            </ul>
                        </nav>
                        <div class="header_extra ml-auto">
                            <div class="shopping_cart">
                                <a href="cart.html">
                                    <div><i class="far fa-shopping-cart fa-lg"></i></div>
                                    <div><span>(0)</span></div>
                                </a>
                            </div>
                            <div class="search">
                                <div class="search_icon">
                                    <div><i class="fas fa-search fa-lg"></i></div>
                                </div>
                            </div>
                            <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="search_panel trans_300">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="search_panel_content d-flex flex-row align-items-center justify-content-end">

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="header_social">
        <ul>
            <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
        </ul>
    </div>
</header>
) } } export default Header;