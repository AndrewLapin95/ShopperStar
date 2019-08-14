import React from "react"; 
import SearchMenu from "./SearchMenu"; 
import IconBoxes from "./IconBoxes"; 
import ProductList from "./ProductList"; 
import Newsletter from "./Newsletter";
import axios from "axios";

class Products extends React.Component { 
    
    constructor(props) {

        super(props);

        this.state = { 
            products: []
        }

        this.onSearchSubmit = this.onSearchSubmit.bind(this);
    }

    async componentDidMount() {

        const category = new URLSearchParams(this.props.location.search).get('category');
        
        if (category !== null) {

            const response = await axios.get("/api/search-products/" + category);

            this.setState({
                products: response.data
            });
        }

    }

    async onSearchSubmit(entry) {

        const response = await axios.get("/api/search-products/" + entry);

        this.setState({
            products: response.data
        });

    }

    render() { 
        return (
            <div className="super_container">
                <div className="products">

                    <SearchMenu text="What are you looking for today?"
                                button="Search" 
                                onSubmit={this.onSearchSubmit} />

                    <ProductList products={this.state.products}/>

                    <IconBoxes />

                </div>
            </div>
        ) 
    } 
} 

export default Products;