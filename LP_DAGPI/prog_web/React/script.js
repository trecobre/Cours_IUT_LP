class Header extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
    return (
        <nav>
            <h1>{this.props.nameApp}</h1>
            <input type="text"></input>
            <button>Rechercher</button>
        </nav>
        );
    }
}

class Body extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
    return (
        <div>AAAA
        </div>
        );
    }
}

class Footer extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
    return (
        <nav>
            aaaa
        </nav>
        );
    }
}

function Main(){
    return (
        <div>
            <Header nameApp="Google API" />
            <Body />
            <Footer />
        </div>
    )
}

ReactDOM.render(
    <Main/>, 
    document.getElementById('root')
);