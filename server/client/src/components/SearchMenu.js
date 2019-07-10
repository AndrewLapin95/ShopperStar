import React from "react"; 

class SearchMenu extends React.Component { 
    constructor(props) {
        super(props);
    }
    
    render() { 
        return (
            <div class="search_menu">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <div class="search_menu_content text-center">
                            <div class="search_menu_text">{this.props.text}</div>
                            <div class="search_menu_form_container">
                                <form action="#" id="search_menu_form" class="search_menu_form">
                                    <input type="text" class="search_menu_input" required="required" />
                                    <button class="search_menu_button trans_200"><span>{this.props.button}</span></button>
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