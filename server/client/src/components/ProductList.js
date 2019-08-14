import React from "react";
import Product from "./Product";
import Pagination from "react-bootstrap/Pagination";

class ProductList extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
            currentPage: 1,
            productsPerPage: 4
          };
          this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event) {
        this.setState({
          currentPage: Number(event.target.id)
        });
      }
    
    render() {

        const { currentPage, productsPerPage } = this.state;

        let products = this.props.products.map((image) => {
            return <Product key={image.id} id = {image.id} image={image.image} title={image.title} category="false"/>
        });

        const indexOfLastProduct = currentPage * productsPerPage;
        const indexOfFirstProduct = indexOfLastProduct - productsPerPage;
        const currentProducts = products.slice(indexOfFirstProduct, indexOfLastProduct);

        const renderedProducts = currentProducts.map((product, index) => {
            return <li key={index}>{product}</li>
        });

        let pageNumbers = []
        for (let i = 1; i <= Math.ceil(products.length / 4); i++) {
            pageNumbers.push(i);
        }

        const renderedPageNumbers = pageNumbers.map((page) => {
            if (renderedProducts.length == 0) {
                return <li></li>;
            } else {
                return <li key={page} id={page} onClick={this.handleClick}>{page}.</li>;
            }
        });

        return (
                <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="product_grid">
                            {renderedProducts} 
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