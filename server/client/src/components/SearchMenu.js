import React from "react"; 

class SearchMenu extends React.Component { 
    constructor(props) {
        
        super(props);

        this.state = { entry: "" };

        this.onFormSubmit = this.onFormSubmit.bind(this);
    }
    
    onFormSubmit(event) {
        event.preventDefault();

        this.props.onSubmit(this.state.entry);

        this.setState({
            entry: ""
        });
    }

    render() { 
        return (
            <div className="search_menu">
                <div className="row">
                    <div className="col-lg-8 offset-lg-2">
                        <div className="search_menu_content text-center">
                            <div className="search_menu_text">{this.props.text}</div>
                            <div className="search_menu_form_container">
                                <form onSubmit={this.onFormSubmit} 
                                      id="search_menu_form" 
                                      className="search_menu_form">
                                    <input value={this.state.entry} 
                                           type="text" 
                                           className="search_menu_input" 
                                           required="required" 
                                           onChange={e => this.setState({ entry: e.target.value })}/>
                                    <button className="search_menu_button trans_200"><span>{this.props.button}</span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ) 
    } 
} 

export default SearchMenu;