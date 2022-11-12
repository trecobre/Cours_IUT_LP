import React from "react";
import Velo from "../Velo/Velo"

class Welcome extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      age:parseInt(this.props.age), 
      nb_an:1, 
      jsonApi:[], 
      contract:"lyon", 
      isValid:true
    };
  }

  componentDidMount(){
    this.getApiData(this.state.contract);
  }

  async getApiData(contract){
    await fetch('https://api.jcdecaux.com/vls/v1/stations?contract='+ contract +'&apiKey=7886a12c53604b2668a08582a04795afcc9375b0')
    .catch(() => {
      this.setState({
        isValid:false
      });
    })
    .then(response => {
      response.json().then(response =>{
        if(!response.error){
          this.setState({
            jsonApi:response,
            isValid:true
          });
        }
      })
    });
  }

  modif_age(isAdd){
    this.setState(() => {
      let newAge = this.state.age;
      if(isAdd){
        newAge += this.state.nb_an;
      }
      else{
        newAge -= this.state.nb_an;
      }
      if(newAge < 0){
        newAge = 0;
      }
      return {age: newAge}
    });
  }

  modif_nb_an(evt){
    this.setState(() => {
      return {nb_an: parseInt(evt.target.value)}
    });
  }

  render() {
    return (
      <div className="div-welcome">
        <h1>Hello {this.props.name}</h1>
        <p>Tu as {this.state.age} ans</p>
        <p><input type="range" min="1" max="100" defaultValue="1" onChange={(evt)=>{this.modif_nb_an(evt)}}></input></p>
        <button onClick={()=>{this.modif_age(true)}}>S'ajouter {this.state.nb_an} an</button>
        <button onClick={()=>{this.modif_age(false)}}>S'enlever {this.state.nb_an} an</button>

        <p>
          <input type="text" placeholder="Chercher une ville" onChange={(evt)=>{
            this.getApiData(evt.target.value).then(()=>{
                if(!this.state.isValid){
                  evt.target.style.border = "thick solid red"
                }
                else{
                  evt.target.style.border = "1px solid black"
                }
              });
            }}></input>
        </p>

        <span>
          {this.state.jsonApi.map((obj)=>
            <Velo 
              name={`${obj.name}`}
              adresse={`${obj.address}`}
              bike_stands={`${obj.bike_stands}`}
              status={`${obj.status}`}
            ></Velo>
          )}
        </span>

      </div>
    );
  }
}


export default Welcome;