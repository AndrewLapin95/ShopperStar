import React from 'react';

class MainNav extends React.Component {
    render() {
        return (
            <nav className="main_nav">
                <ul>
                    <li className="hassubs active">
                        <a href="/">Home</a>
                            <ul>
                                <li><a href="/categories">Categories</a></li>
                                <li><a href="/products">Product</a></li>
                                <li><a href="/contact">Contact</a></li>
                            </ul>
                            </li>
                            <li><a href="/products">Products</a></li>
                            <li className="hassubs">
                                <a href="/categories">Categories</a>
                                <ul>
                                    <li><a href="/products">Phones</a></li>
                                    <li><a href="/products">Laptops</a></li>
                                    <li><a href="/products">Cameras</a></li>
                                    <li><a href="/products">Headphones</a></li>
                                </ul>
                            </li>
                            <li><a href="/contact">Contact</a></li>
                </ul>
            </nav>
        );
    }
}

export default MainNav;