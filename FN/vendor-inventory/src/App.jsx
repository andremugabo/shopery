import { RouterProvider } from 'react-router'
import './App.css'
import {Provider} from 'react-redux'
import {router} from './routes'
import { store } from './store'
 
function App() {
 

  return (
    <>
      <Provider store={store}>
            <RouterProvider router={router}/>
      </Provider>
    </>
  )
}

export default App
