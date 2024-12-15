import { RouterProvider } from 'react-router'
import './App.css'
import {Provider} from 'react-redux'
import {router} from './routes'
 
function App() {
 

  return (
    <>
      <Provider>
            <RouterProvider router={router}/>
      </Provider>
    </>
  )
}

export default App