import './Pane.css';

function PaneContents(props) {
    
    return (
    <div className="pane" id={props.title}>
      <h3>{props.title}</h3>
      <p>{props.content}</p>
      <button onClick={props.remove} className="remove-button">[x]</button>
    </div>
    );
  }
  
  export default PaneContents;