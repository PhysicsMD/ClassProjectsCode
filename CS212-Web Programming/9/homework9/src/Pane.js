import { useState } from 'react';

import './Pane.css';
import PaneContents from './PaneContents';

function Pane(props) {
    const [taskISOpen, setTaskIsOpen] = useState(true);

    function remove(){
        setTaskIsOpen(taskISOpen == false)
        console.log(props.title+' Closed')
    }
    
    return (<div>
    {taskISOpen ? <PaneContents title={props.title} content={props.content} remove={remove}/>: null}
    </div>
    );
  }
  
  export default Pane;