import Dashboard from 'pages/Dashboard';
import Home from 'pages/Home';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/dashboard" component={Dashboard} />
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;