import React from "react";
import './Velo.css';

class Velo extends React.Component{
    constructor(props){
      super(props);
    }

    render() {
      return (
        <div className="div-velo">
            <p> Nom : {this.props.name}</p>
            <p> Adresse : {this.props.adresse}</p>
            <p> Nombre d'emplacement : {this.props.bike_stands}</p>
            <p> status : {this.props.status}</p>
        </div>
      );
    }
  }
  
  
  export default Velo;