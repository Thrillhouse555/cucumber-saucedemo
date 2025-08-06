const { Given, Then, After, Before } = require('@cucumber/cucumber');
const { Builder } = require('selenium-webdriver');

let driver;

Before(async function () {
  driver = await new Builder().forBrowser('chrome').build();
});

After(async function () {
  if (driver) {
    await driver.quit();
  }
});

Given('I open the Google homepage', async function () {
  await driver.get('https://www.google.com');
});

Then('the page title should be {string}', async function (expectedTitle) {
  const title = await driver.getTitle();
  if (title !== expectedTitle) {
    throw new Error(`Expected title to be "${expectedTitle}" but got "${title}"`);
  }
});
