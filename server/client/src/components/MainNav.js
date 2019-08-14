import React from 'react'; 

class MainNav extends React.Component { 
    render() { 
        return (
            <nav className="main_nav">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/products">Products</a></li>
                    <li className="hassubs">
                        <a href="/categories">Categories</a>
                        <ul>
                            <li><a href="/products?category=phones">Phones</a></li>
                            <li><a href="/products?category=laptops">Laptops</a></li>
                            <li><a href="/products?category=cameras">Cameras</a></li>
                            <li><a href="/products?category=headphones">Headphones</a></li>
                        </ul>
                    </li>
                    <li><a href="/contact">Contact</a></li>
                </ul>
            </nav>
        ); 
    } 
} 

export default MainNav;