import React from "react";
import Product from "./Product";
import Pagination from "react-bootstrap/Pagination";

class ProductList extends React.Component {
    
    constructor(props) {
        super(props);
    }
    
    render() {

        let products = this.props.products.map((image) => {
            return <Product key={image.id} id = {image.id} image={image.image} title={image.title} category="false"/>
        });

        let pageNumbers = []
        for (let i = 1; i < Math.ceil(products.length / 4); i++) {
            pageNumbers.push(i);
        }

        const renderedPageNumbers = pageNumbers.map((page) => {
            return <li><a href="#">01.</a></li>;
        });

        return (
                <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="product_grid">
                            {products} 
                        </div>
                    </div>
                </div>
                <div class="product_pagination">
                    <ul>
                       {renderedPageNumbers}
                    </ul>
                </div> 
            </div>
        );
    }
}

export default ProductList;